package org.shootChallenge.ui;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import org.shooterCRUD.ui.ShooterCrudForm;



public class ShooterCrudFormExt extends ShooterCrudForm {
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        Button backBtn = new Button("Назад", e-> ((MainNavigatorUI) getUI()).getNavigator().navigateTo(((MainNavigatorUI) getUI()).SHOOT_CRUD_FORM));
        super.hLayout.addComponent(backBtn);
    }
}
