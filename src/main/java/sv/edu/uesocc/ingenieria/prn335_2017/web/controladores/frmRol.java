/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.AbstractInterface;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.CategoriaFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Categoria;

/**
 *
 * @author juancarlos
 */
@Named(value = "frmCategoria")
@ViewScoped
public class frmRol extends GenericMB<Categoria> implements Serializable{

    public frmRol() {
    }

    @EJB
    RolFacadeLocal facade;
    Rol RolEntity;
    boolean btnVisible=false;
    
    boolean btnadd = false;
    boolean botones = false;
    boolean botones2 = false;
    

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public RolFacadeLocal getFacade() {
        return facade;
    }

    public boolean isBtnVisible() {
        return btnVisible;
    }

    public void setBtnVisible(boolean btnVisible) {
        this.btnVisible = btnVisible;
    }
    
    public void setFacade(RolFacadeLocal facade) {
        this.facade = facade;
    }

    public Rol getRolEntity() {
        return RolEntity;
    }

    public void setRolEntity(Rol RolEntity) {
        this.RolEntity = RolEntity;
    }

    public List<Rol> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<Categoria> listaDatos) {
        this.listaDatos = listaDatos;
    }
    
    public boolean isBtnadd() {
        return btnadd;
    }

    public void setBtnadd(boolean btnadd) {
        this.btnadd = btnadd;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }
    
    public boolean isBotones2() {
        return botones2;
    }

    public void setBotones2(boolean botones2) {
        this.botones2 = botones2;
    }
    

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Overrrides">
    @Override
    public Rol getEntity() {
        return RolEntity;
    }

    @Override
    protected AbstractInterface<Rol> getFacadeLocal() {
        return facade;
    }

    @Override
    public void editar() {
        super.editar();
        this.botones = false;
        this.botones2 = false;
        this.btnadd = true;
        reiniciarValores();
    }

    @Override
    public void eliminar() {
        super.eliminar();
        this.botones = false;
        this.botones2 = false;
        this.btnadd = true;
        reiniciarValores();
    }

    @Override
    public void crear() {
        super.crear(); 
        reiniciarValores();
    }
    // </editor-fold>
    
    @PostConstruct
    public void init(){
        llenarLista();
    }
    
    
    public void onRowSelect(SelectEvent event) {
        btnVisible = true;
    }
    
    public void btnCancelar() {
        RolEntity = new Rol();
        this.botones=false;
        this.btnadd=false;
        this.botones2=false;
    }
    
    public void nuevo(){
    RolEntity = new Rol();
    this.botones = true;
    this.btnadd = true;
    this.botones2=false;
    }
    
    public void reiniciarValores(){
        RolEntity.setActivo(false);
        RolEntity.setDescripcion(null);
        RolEntity.setIdCategoria(null);
        RolEntity.setNombre(null);
    }
    
    public void cambiarSeleccion() {
        this.botones = false;
        this.btnadd = true;
        this.botones2=true;

    }
}
