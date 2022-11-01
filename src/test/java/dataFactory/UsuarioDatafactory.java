package dataFactory;

import org.jetbrains.annotations.NotNull;
import pojo.UsuarioPojo;

public class UsuarioDatafactory {

       public static UsuarioPojo criarUsuarioAdm (){

           UsuarioPojo usuario = new UsuarioPojo();
           //usuario.setUsuarioNome("Tiago Anderson PTQS5");
           usuario.setUsuarioLogin("tiagoanderson");
           usuario.setUsuarioSenha("123456");
        return usuario;




    }
}
