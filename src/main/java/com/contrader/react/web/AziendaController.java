package com.contrader.react.web;

import com.contrader.react.dto.AziendaDTO;
import com.contrader.react.service.AziendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/aziende")
public class AziendaController {
    private final AziendaService aziendaService;
    
    @Autowired
    public AziendaController(AziendaService aziendaService){
        this.aziendaService = aziendaService;
    }
    
    @GetMapping
    public List<AziendaDTO> getAll(){
        return aziendaService.getAll();
    }
    @GetMapping("/{id}")
    public AziendaDTO getAzienda(@PathVariable("id")Integer id){
        return aziendaService.getById(id);
    }
    @PostMapping()
    public AziendaDTO saveAzienda(@RequestBody AziendaDTO aziendaDTO){
        return aziendaService.add(aziendaDTO);
    }
    @PutMapping()
    public AziendaDTO updateAzienda(@RequestBody AziendaDTO aziendaDTO){
        return aziendaService.edit(aziendaDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteAzienda(@PathVariable("id")Integer id){
        aziendaService.deleteById(id);
    }
}
