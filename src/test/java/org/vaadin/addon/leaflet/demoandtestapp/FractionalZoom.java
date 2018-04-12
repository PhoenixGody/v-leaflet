package org.vaadin.addon.leaflet.demoandtestapp;

import com.vaadin.data.Property;
import org.vaadin.addon.leaflet.LMap;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;
import org.vaadin.addonhelpers.AbstractTest;

public class FractionalZoom extends AbstractTest {
    
    @Override
    public String getDescription() {
        return "Test fractional zoom introduced in 1.0-beta1.";
    }
    
    private LMap leafletMap;
    
    @Override
    public Component getTestComponent() {
        
        leafletMap = new LMap();
        leafletMap.setWidth("300px");
        leafletMap.setHeight("300px");
        leafletMap.setCenter(0, 0);
        leafletMap.setZoomLevel(2.5);
        leafletMap.addLayer(new LOpenStreetMapLayer());
        
        final Slider slider = new Slider("ZoomLevel");
        slider.setWidth("200px");
        slider.setMin(1);
        slider.setMax(16);
        slider.setResolution(1);
        slider.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                leafletMap.setZoomLevel(slider.getValue());
                Notification.show("Zoom level: " + slider.getValue(), Notification.Type.TRAY_NOTIFICATION);
            }
        });
        
        return new VerticalLayout(leafletMap, slider);
    }
}
