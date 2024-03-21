package web.pet.web_surveys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.pet.web_surveys.controller.payload.NewClientPayload;
import web.pet.web_surveys.entity.Client;
import web.pet.web_surveys.service.ClientService;

@Controller
@RequiredArgsConstructor
@RequestMapping("clients")
public class ClientsController {

    private final ClientService clientService;

    @GetMapping("new")
    public String getNewClientForm() {
        return "client/new";
    }

    @PostMapping("new")
    public String addNewClient(NewClientPayload payload) {
        Client client = clientService.addNewClient(payload.name(), payload.gender());
        return "redirect:/clients/" + client.getId();
    }

    @GetMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.findAllClients());
        return "client/list";
    }
}
