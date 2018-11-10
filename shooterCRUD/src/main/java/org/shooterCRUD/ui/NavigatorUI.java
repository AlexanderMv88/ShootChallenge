package org.shooterCRUD.ui;


import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.shooterCRUD.repository.ShooterRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;


@Theme("valo")
@SpringUI(path = "/")
public class NavigatorUI extends CommonUI {
    private Navigator navigator;
    public static final String SHOOTER_CRUD_FORM = "shooterCrudFrom";



    @Override
    public Navigator getNavigator() {
        return navigator;
    }

    public NavigatorUI(ShooterRepository shooterRepository) {
        repositories.put("shooterRepository", shooterRepository);
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator = new Navigator(this, this);
        navigator.addView(SHOOTER_CRUD_FORM, ShooterCrudForm.class);
        navigator.navigateTo(SHOOTER_CRUD_FORM);
    }
}
