package com.sourav.petclinic.controller;

import com.sourav.petclinic.exceptionClasses.InvalidFormat;
import com.sourav.petclinic.exceptionClasses.NotFoundException;
import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.services.OwnerServices;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class OwnerController {
    private final OwnerServices ownerServices;

    OwnerController(OwnerServices ownerServices){
        this.ownerServices = ownerServices;
    }



    @RequestMapping({"/owners","/owner","owners/index","owner/index","owners/index.html","owner/index.html"})
    public String ownerIndex(Model model){
        Set<Owner> setOfOwners = ownerServices.findAll();
        System.out.println("Size of owner's list = "+setOfOwners.size());
        model.addAttribute("owners",ownerServices.findAll());
        return "owners/index";
    }

//    @GetMapping("/owners/{ownerId}")
//    public ModelAndView getOwner(@PathVariable Long ownerId){
//
//        ModelAndView mv = new ModelAndView("owners/ownerDetails");
//        mv.addObject(ownerServices.findById(ownerId));
//        return mv;
//    }

    @GetMapping("/owners/{ownerId}")
    public ModelAndView getOwner(@PathVariable String ownerId){
        ModelAndView mv = new ModelAndView("owners/ownerDetails");
        try {
            mv.addObject(ownerServices.findById(new Long(ownerId)));
        }catch(NumberFormatException numberFormatException){
            throw new InvalidFormat("The id: "+ownerId+" should be a number");
        }finally {}
        return mv;
    }

    @GetMapping("owners/find")
    public ModelAndView findOwner(){
        ModelAndView mv = new ModelAndView("owners/findOwners");
        mv.addObject(new Owner());
        return mv;
    }

    @PostMapping("owners/find")
    public String findOwnerByName(@ModelAttribute Owner owner, Model model){
        final Long[] id = {-1l};
        Set<Owner> ownerFound = null;

        if((owner.getLastName()==null || owner.getLastName().trim().length() == 0) &&
                (owner.getFirstName() == null || owner.getFirstName().trim().length() == 0 ))
            return "redirect:/owners";
        if(owner.getLastName().trim().length()>0){
            System.out.println("owner has a last name --> "+owner.getLastName());
            try{
                ownerFound = ownerServices.findByLastName(owner.getLastName());
            }catch(Exception e){
                System.out.println("Got exception in findOwnerByName");
                e.printStackTrace();
            }
            if(ownerFound == null)
                throw new RuntimeException("Sorry!! There is no owner with that last name.");
            else
                System.out.println("Owner has been found, number of owners found -->"+ownerFound.size());
        }



        if(owner.getFirstName() == null || owner.getFirstName().trim().length() == 0    ){
            model.addAttribute("owners",ownerFound);
            return "owners/index";
        }
        else
            System.out.println("Owner has a first name --> "+owner.getFirstName());

        if(ownerFound == null){
            try{
                ownerFound = ownerServices.findByFirstName(owner.getFirstName());
            }catch (Exception e){
                System.out.println("Got exception in findOwnerByName");
                e.printStackTrace();
            }finally { }
            if(ownerFound == null)
                throw new RuntimeException("Sorry!! There is no owner with that last name.");
            else {
                System.out.println("Owner has been found, number of owners found -->" + ownerFound.size());
                if(ownerFound.size()>1){
                    System.out.println("there are multiple owners with that first name");
                    model.addAttribute("owners",ownerFound);
                    return "owners/index";
                }
                else{
                    System.out.println("There is only one owner with that first name");
                    ownerFound.forEach(vOwner -> id[0] = vOwner.getId());
                }
            }
        }
        else{
            ownerFound.forEach(ownr -> {
                if(ownr.getFirstName().equalsIgnoreCase(owner.getFirstName())) {
                    id[0] = ownr.getId();
                }
            });
        }

        if(id[0] == -1l)
            throw new RuntimeException("Sorry!! There is no owner with that first name.");
        return "redirect:/owners/"+id[0];
    }

    @GetMapping("/owners/new")
    public ModelAndView createNewOwner(){
        Owner owner = new Owner();
        ModelAndView mv = new ModelAndView("owners/addOrUpdateOwners");
        mv.addObject(owner);
        return mv;
    }
    @PostMapping("/owners/new")
    public String createNewOwner(@ModelAttribute Owner owner){
        Owner savedOwner = ownerServices.save(owner);
        return "redirect:/owners/"+savedOwner.getId();
    }

    @GetMapping("/owners/{id}/edit")
    public ModelAndView editOwner(@PathVariable Long id) throws  Exception{
       Owner owner =  ownerServices.findById(id);
       ModelAndView mv = new ModelAndView("owners/addOrUpdateOwners");
       if(owner == null)
           throw new RuntimeException("There is no owner with the id: "+id);
       mv.addObject(owner);
       return mv;
    }

    @PostMapping("/owners/{id}/edit")
    public String editOwner(@ModelAttribute Owner owner){
        Owner savedOwner = ownerServices.save(owner);
        return "redirect:/owners/"+savedOwner.getId();
    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView notFoundExceptionHandler(Exception exception){
        ModelAndView mv = new ModelAndView("error/404");
        mv.addObject("exception",exception);
        return mv;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormat.class)
    public ModelAndView NumberFormatException(Exception exception){
        ModelAndView mv = new ModelAndView(("error/400"));
        mv.addObject("exception",exception);
        return mv;

    }
}
