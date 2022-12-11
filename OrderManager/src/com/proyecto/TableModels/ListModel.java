package com.proyecto.TableModels;

import javax.swing.*;
import java.util.List;


public class ListModel<T> extends AbstractListModel<T> {
    List<T> datos;

    public ListModel(List<T> datos) {
        this.datos = datos;
    }

    @Override
    public int getSize() {
        return datos.size();
    }

    @Override
    public T getElementAt(int index) {
        return datos.get(index);
    }


}
