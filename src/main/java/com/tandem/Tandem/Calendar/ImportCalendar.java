package com.tandem.Tandem.Calendar;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.CalendarComponent;

public class ImportCalendar {

    private String fieldsToSave[] = { "DTSTART", "DTEND", "SUMMARY", "LOCATION", "DESCRIPTION" };

    public void parseCalendarFile(String calendarPath) throws IOException, ParserException {
        FileInputStream fin = new FileInputStream(calendarPath);
        CalendarBuilder cb = new CalendarBuilder();
        Calendar cal = cb.build(fin);

        for (Iterator<CalendarComponent> i = cal.getComponents().iterator(); i.hasNext();) {
            Component component = (Component) i.next();
            System.out.println("Component [" + component.getName() + "]");

            for (Iterator<Property> j = component.getProperties().iterator(); j.hasNext();) {
                Property property = (Property) j.next();
                for (String fields : fieldsToSave) {
                    if (property.getName().toUpperCase().equals(fields.toUpperCase())) {
                        System.out.println("Property [" + property.getName() + ", " + property.getValue() + "]");
                    }
                }
            }
        }
    }
}