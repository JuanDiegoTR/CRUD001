package com.crud.crud.controlador;

import com.crud.crud.modelo.Usuario;
import com.crud.crud.servicio.Impl.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CRUD/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicioImpl usuarioServicio;


    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuario() {
        return usuarioServicio.listarUsuario();
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable("id") Long id) {
        return usuarioServicio.eliminarUsuario(id);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Usuario> listarUsuarioPorId(@PathVariable("id") Long id) {
        return usuarioServicio.usuarioPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario,@PathVariable("id") Long id) {
          return usuarioServicio.actualizarUsuario(usuario, id);
    }


}
