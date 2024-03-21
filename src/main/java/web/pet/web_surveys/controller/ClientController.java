package web.pet.web_surveys.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.pet.web_surveys.controller.payload.UpdateClientPayload;
import web.pet.web_surveys.entity.Client;
import web.pet.web_surveys.service.ClientService;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("clients/{clientId}")
public class ClientController {

    private final ClientService clientService;

    @ModelAttribute("client")
    public Client client(@PathVariable Integer clientId) {
        return clientService.findById(clientId).orElseThrow(() -> new NoSuchElementException("Товар не найден"));
    }

    @GetMapping
    public String getClient() {
        return "client/details";
    }

    @GetMapping("edit")
    public String getEditClientForm() {
        return "client/edit";
    }

    @PostMapping("edit")
    public String updateClient(@ModelAttribute("client") Client client, UpdateClientPayload payload) {
        clientService.updateClient(client.getId(), payload.name(), payload.gender());
        return "redirect:/clients/" + client.getId();
    }

    @PostMapping("delete")
    public String deleteClient(@ModelAttribute("client") Client client) {
        clientService.deleteClient(client.getId());
        return "redirect:/clients";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(NoSuchElementException exception, Model model,
    HttpServletResponse response) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        model.addAttribute("error", exception.getMessage());
        return "errors/404";
    }
}
