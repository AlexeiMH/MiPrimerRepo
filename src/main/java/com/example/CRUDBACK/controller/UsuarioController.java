package com.example.CRUDBACK.controller;

import com.example.CRUDBACK.Entity.Usuario;
import com.example.CRUDBACK.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{usuarioId}")
    public Optional<Usuario> getById(@PathVariable("usuarioId") Long usuarioId){
        return usuarioService.getUsuarios(usuarioId);
    }

    @PostMapping
    public Usuario saveUpdate(@RequestBody Usuario usuario){
        usuarioService.saveOrUpdate(usuario);
        return usuario;
    }

    @DeleteMapping("/{usuarioId}")
    public void saveUpdate(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.delete(usuarioId);
    }


}
