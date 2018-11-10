/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shooterCRUD.helper;

import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class Formats {
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
    public static SimpleDateFormat dateFormat= new SimpleDateFormat("dd.MM.yyyy");
    public static SimpleDateFormat longDateFormat= new SimpleDateFormat("dd MMMM yyyy");
    public static SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    public static SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    public static SimpleDateFormat longMonthFormat = new SimpleDateFormat("MMMM yy");
}
