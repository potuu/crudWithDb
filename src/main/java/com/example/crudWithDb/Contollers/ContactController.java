package com.example.crudWithDb.Contollers;

import com.example.crudWithDb.Entities.Contact;
import com.example.crudWithDb.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping({"/", ""})
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        model.addAttribute("contacts", contactService.listContacts(keyword));
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping("/new")
    public String showRegisterForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "new";
    }

    @PostMapping("/new")
    public String registerContact(@Validated @ModelAttribute Contact contact, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contact", contact);
            return "new";
        }

        contactService.registerContact(contact);
        redirectAttributes.addFlashAttribute("msgSuccess", "Contact successfully registered");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("contact", contactService.searchContactById(id));
        return "new";
    }

    @PostMapping("/edit/{id}")
    public String updateContact(@PathVariable Integer id, @ModelAttribute("contact") @Validated Contact contact, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contact", contact);
            return "new";
        }

        Contact currentContact = contactService.searchContactById(id);
        currentContact.setName(contact.getName());
        currentContact.setEmail(contact.getEmail());
        currentContact.setPhone(contact.getPhone());
        currentContact.setBirthDate(contact.getBirthDate());

        contactService.updateContact(currentContact);
        redirectAttributes.addFlashAttribute("msgSuccess", "Contact successfully updated");
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteContact(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        contactService.deleteContact(id);
        redirectAttributes.addFlashAttribute("msgSuccess", "Contact successfully deleted");
        return "redirect:/";
    }
}
