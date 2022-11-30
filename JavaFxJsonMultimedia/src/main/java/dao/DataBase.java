package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Configuracion;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;
import modelo.Cliente;
import modelo.Peli;
import modelo.Serie;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public class DataBase {

    private Gson gson;
    private Configuracion configuracion;
    @Inject
    public DataBase(Gson gson) {
        this.gson = gson;
        this.configuracion = Configuracion.getInstance();
    }


    public List<Peli> loadPelis(){
        Type userListType = new TypeToken<List<Peli>>() {
        }.getType();

        List<Peli> pelis = new ArrayList<>();
        try (FileReader fr=new FileReader(configuracion.getListaPelis())){
            pelis = gson.fromJson(
                    fr,
                    userListType);
        } catch (IOException ioException) {
            log.error(ioException.getMessage(),ioException);
        }
        return pelis;
    }

    public boolean savePelis(List<Peli> pelis) {

        try (FileWriter w = new FileWriter(configuracion.getListaPelis())) {
            gson.toJson(pelis, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
    public List<Serie> loadSeries(){
        Type userListType = new TypeToken<List<Serie>>() {
        }.getType();
        List<Serie> series = new ArrayList<>();
        try (FileReader fr=new FileReader(configuracion.getListaSeries())){
            series = gson.fromJson(
                    fr,
                    userListType);
        } catch (IOException ioException) {
            log.error(ioException.getMessage(),ioException);
        }
        return series;
    }
    public boolean saveSeries(List<Serie> series) {
        try (FileWriter w = new FileWriter(configuracion.getListaSeries())) {
            gson.toJson(series, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
    public Map<String,Cliente> loadClientes(){
        Type userListType = new TypeToken<Map<String,Cliente>>() {
        }.getType();
        Map<String,Cliente> clientes = new HashMap<>();
        try (FileReader fr=new FileReader(configuracion.getListaClientes())){
            clientes = gson.fromJson(
                    fr,
                    userListType);
        } catch (IOException ioException) {
            log.error(ioException.getMessage(),ioException);
        }
        return clientes;
    }
    public boolean saveClientes(Map<String,Cliente> clientes) {
        try (FileWriter w = new FileWriter(configuracion.getListaClientes())) {
            gson.toJson(clientes, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
}
