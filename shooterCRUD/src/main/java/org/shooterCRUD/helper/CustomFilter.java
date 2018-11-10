/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shooterCRUD.helper;

import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.components.grid.HeaderCell;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.themes.ValoTheme;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * Пример использования: 
 * 
 * 
 
 for (final Grid.Column<Owner, ?> column : objGrid.getColumns()) {
    final HeaderCell headerCell = filterRow.getCell(column);
    if (column.getCaption().toLowerCase().contains("дата")){
        headerCell.setComponent(new CustomFilter<Owner>().createFilterDateField(column, objGrid));
    }else{
        headerCell.setComponent(new CustomFilter<Owner>().createFilterTextField(column, objGrid));
    }

} 

 */
public class CustomFilter<T> {

    public TextField createFilterTextField(final Grid.Column<T, ?> column, Grid<T> grid) {

        final TextField tfFilter = new TextField();
        //tfFilter.focus();
        tfFilter.addStyleName(ValoTheme.TEXTFIELD_TINY);
        tfFilter.setWidth(100, Sizeable.Unit.PERCENTAGE);
        tfFilter.addValueChangeListener(event -> {
            updateAllObjFilter(grid);
        });
        return tfFilter;
    }

    public DateField createFilterDateField(final Grid.Column<T, ?> column, Grid<T> grid) {
        final DateField dtField = new DateField();
        dtField.setDateFormat(Formats.dateFormat.toPattern());

        dtField.addStyleName(ValoTheme.TEXTFIELD_TINY);
        dtField.setWidth(100, Sizeable.Unit.PERCENTAGE);
        dtField.addValueChangeListener(event -> {
            updateAllObjFilter(grid);
        });
        return dtField;
    }

    private void updateAllObjFilter(Grid<T> grid) {
        ListDataProvider<T> listDataProviderResponsibility = (ListDataProvider<T>) grid.getDataProvider();
        listDataProviderResponsibility.clearFilters();

        HeaderRow filterRow = grid.getHeaderRow(1);

        for (final Grid.Column<T, ?> column : grid.getColumns()) {
            final HeaderCell headerCell = filterRow.getCell(column);

            if (column.getCaption().toLowerCase().contains("дата")) {
                final DateField dateField = (DateField) headerCell.getComponent();

                final ValueProvider<T, Date> valueProvider = (ValueProvider<T, Date>) column.getValueProvider();

                if (dateField.getValue() != null && valueProvider != null) {
                    listDataProviderResponsibility.addFilter(valueProvider, value -> {
                        Date dt = Date.from(dateField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                        if (value != null) {
                            return value.equals(dt);
                        } else {
                            return false;
                        }
                    });
                }
            } 
            //Фильтр по целому числу
            /*else if (column.getCaption().equals("№")) {

                final ValueProvider<T, Integer> valueProvider = (ValueProvider<T, Integer>) column.getValueProvider();

                final TextField textField = (TextField) headerCell.getComponent();

                if (textField.getValue() != null && !textField.getValue().isEmpty()) {

                    try {
                        Integer intVal = Integer.parseInt(textField.getValue());
                        listDataProviderResponsibility.addFilter(valueProvider, value -> {

                            return Integer.valueOf(value) == intVal;

                        });
                    } catch (NumberFormatException e) {

                    }

                }
            } */else {

                final TextField textField = (TextField) headerCell.getComponent();

                final ValueProvider<T, String> valueProvider = (ValueProvider<T, String>) column.getValueProvider();

                if (textField.getValue() != null && !textField.getValue().isEmpty()) {
                    listDataProviderResponsibility.addFilter(valueProvider, value -> {
                        return value.toLowerCase().contains(textField.getValue().toLowerCase());
                    });
                }
            }

        }
        listDataProviderResponsibility.refreshAll();
    }
}
