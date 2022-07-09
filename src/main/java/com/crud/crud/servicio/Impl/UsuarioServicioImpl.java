package com.crud.crud.servicio.Impl;

import com.crud.crud.modelo.Usuario;
import com.crud.crud.repositorio.UsuarioRepositorio;
import com.crud.crud.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public ResponseEntity<List<Usuario>> listarUsuario() {
        try {
            List<Usuario> usuarios = usuarioRepositorio.findAll();
            if (usuarios.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(usuarios);
        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }
        return null;
    }

    @Override
    public ResponseEntity<Usuario> guardarUsuario(Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioRepositorio.save(usuario);
            if (nuevoUsuario == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(usuario);
        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }
        return null;
    }

    @Override
    public ResponseEntity<Usuario> eliminarUsuario(Long id) {
        try {
            usuarioRepositorio.deleteById(id);
        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }
        return null;
    }

    @Override
    public ResponseEntity<Usuario> usuarioPorId(Long id) {
        try {
            Usuario usuario = usuarioRepositorio.findById(id).orElse(null);
            if (usuario == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(usuario);
        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }
        return null;
    }

    @Override
    public ResponseEntity<Usuario> actualizarUsuario(Usuario usuario, Long id) {
        try {
            var usuarioExistente = usuarioRepositorio.findById(id);
            usuario.setNombre(usuario.getNombre());
            usuario.setEdad(usuario.getEdad());
            usuario.setCorreo(usuario.getCorreo());
            usuarioRepositorio.save(usuario);
            return  new ResponseEntity<Usuario>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
}
