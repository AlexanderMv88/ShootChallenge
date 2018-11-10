package org.shootChallenge.ui;


import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.shootChallenge.repository.ShootRepository;
import org.shooterCRUD.repository.ShooterRepository;
import org.shooterCRUD.ui.CommonUI;
import org.shooterCRUD.ui.ShooterCrudForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;


@Theme("valo")
@SpringUI(path = "/")
public class MainNavigatorUI extends CommonUI {
    private Navigator navigator;
    public static final String SHOOTER_CRUD_FORM = "shooterCrudFrom";
    public static final String SHOOT_CRUD_FORM = "shootCrudFrom";

    //public final HashMap<String, JpaRepository> repositories = new HashMap<String, JpaRepository>();

    @Override
    public Navigator getNavigator() {
        return navigator;
    }

    public MainNavigatorUI(ShooterRepository shooterRepository, ShootRepository shootRepository) {
        repositories.put("shooterRepository", shooterRepository);
        repositories.put("shootRepository", shootRepository);
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator = new Navigator(this, this);
        navigator.addView(SHOOTER_CRUD_FORM, ShooterCrudForm.class);
        navigator.addView(SHOOT_CRUD_FORM, ShootCrudForm.class);
        navigator.navigateTo(SHOOT_CRUD_FORM);
    }
}
