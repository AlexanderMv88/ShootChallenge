package org.shooterCRUD.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.HeaderCell;
import com.vaadin.ui.components.grid.HeaderRow;
import org.shooterCRUD.entity.Shooter;
import org.shooterCRUD.helper.CustomFilter;
import org.shooterCRUD.repository.ShooterRepository;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.AbstractAutoGeneratedCrudFormFactory;
import org.vaadin.crudui.form.impl.form.factory.GridLayoutCrudFormFactory;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.vaadin.ui.UI.getCurrent;

public class ShooterCrudForm extends Panel implements View {

    private VerticalLayout hLayout;

    public ShooterCrudForm() {
    }

    protected void init(VaadinRequest request) {
    }

    private void renameCrudWindowButtons(AbstractAutoGeneratedCrudFormFactory crudFormFactory) {
        crudFormFactory.setButtonCaption(CrudOperation.ADD, "Создать");
        crudFormFactory.setButtonCaption(CrudOperation.UPDATE, "Изменить");
        crudFormFactory.setButtonCaption(CrudOperation.DELETE, "Удалить");
        crudFormFactory.setCancelButtonCaption("Отмена");
        crudFormFactory.setButtonCaption(CrudOperation.READ, "Сброс");
    }

    private GridCrud<Shooter> createCompCrudUI() throws UnsupportedOperationException {
        GridLayoutCrudFormFactory<Shooter> objFormFactory = new GridLayoutCrudFormFactory<>(Shooter.class, 1, Shooter.class.getDeclaredFields().length - 1);

        GridCrud<Shooter> objCrudUI = new GridCrud<>(Shooter.class, new HorizontalSplitCrudLayout(), objFormFactory);

        renameCrudWindowButtons(objFormFactory);

        Map<String, String> columnsWithCaptions = new LinkedHashMap<String, String>() {
            {
                this.put("fullName", "Полное имя");
            }
        };

        setCaptionsToGridAndWindow(objFormFactory, objCrudUI, columnsWithCaptions);
        objCrudUI.getGrid().getColumn("id").setHidden(true);
        createCustomFilter(objCrudUI.getGrid());
        objCrudUI.setCrudFormFactory(objFormFactory);

        objCrudUI.setCrudListener(new CrudListener<Shooter>() {
            @Override
            public Collection<Shooter> findAll() {
                return ((ShooterRepository) ((CommonUI) getCurrent()).repositories.get("shooterRepository")).findAll();
            }

            @Override
            public Shooter add(Shooter shooter) {
                return ((ShooterRepository) ((CommonUI) getCurrent()).repositories.get("shooterRepository")).save(shooter);
            }

            @Override
            public Shooter update(Shooter shooter) {
                return ((ShooterRepository) ((CommonUI) getCurrent()).repositories.get("shooterRepository")).save(shooter);
            }

            @Override
            public void delete(Shooter shooter) {
                ((ShooterRepository) ((CommonUI) getCurrent()).repositories.get("shooterRepository")).delete(shooter);
            }
        });
        return objCrudUI;
    }

    private void setCaptionsToGridAndWindow(AbstractAutoGeneratedCrudFormFactory crudFormFactory, GridCrud crudUI, Map<String, String> columnsWithCaptions) {
        String[] columns = columnsWithCaptions.keySet().toArray(new String[columnsWithCaptions.keySet().size()]);
        crudFormFactory.setVisibleProperties(columns);
        String[] captions = columnsWithCaptions.values().toArray(new String[columnsWithCaptions.values().size()]);
        crudFormFactory.setFieldCaptions(captions);

        for (Map.Entry<String, String> entry : columnsWithCaptions.entrySet()) {
            String column = entry.getKey();
            String caption = entry.getValue();
            crudUI.getGrid().getColumn(column).setCaption(caption);
        }
    }

    private void createCustomFilter(Grid<Shooter> objGrid) {
        final HeaderRow filterRow = objGrid.appendHeaderRow();
        for (final Grid.Column<Shooter, ?> column : objGrid.getColumns()) {
            final HeaderCell headerCell = filterRow.getCell(column);
            if (column.getCaption().toLowerCase().contains("дата")) {
                headerCell.setComponent(new CustomFilter<Shooter>().createFilterDateField(column, objGrid));
            } else {
                headerCell.setComponent(new CustomFilter<Shooter>().createFilterTextField(column, objGrid));
            }
        }

    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {
        GridCrud<Shooter> CompCrudUI = createCompCrudUI();

        hLayout = new VerticalLayout(CompCrudUI);
        this.setContent(hLayout);
    }

}