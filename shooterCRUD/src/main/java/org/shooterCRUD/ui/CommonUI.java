package org.shooterCRUD.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;

public class CommonUI extends UI {

    public final HashMap<String, JpaRepository> repositories = new HashMap<String, JpaRepository>();
    @Override
    protected void init(VaadinRequest vaadinRequest) {

    }
}
