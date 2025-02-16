
package com.toedter.components;

import java.awt.Image;
import java.beans.PropertyEditorManager;
import java.beans.SimpleBeanInfo;
import java.util.Locale;


public class GenericBeanInfo extends SimpleBeanInfo {
	
	protected Image iconColor16;

	
	protected Image iconColor32;

	
	protected Image iconMono16;

	
	protected Image iconMono32;

	
	public GenericBeanInfo(String bean, boolean registerLocaleEditor) {
		try {
			iconColor16 = loadImage("images/" + bean + "Color16.gif");
			iconColor32 = loadImage("images/" + bean + "Color32.gif");
			iconMono16 = loadImage("images/" + bean + "Mono16.gif");
			iconMono32 = loadImage("images/" + bean + "Mono32.gif");
		} catch (RuntimeException e) {
			System.out.println("GenericBeanInfo.GenericBeanInfo(): " + e);
		}
		
		if(registerLocaleEditor) {
			PropertyEditorManager.registerEditor(Locale.class,LocaleEditor.class);
		}
	}

	
	public Image getIcon(int iconKind) {
		switch (iconKind) {
			case ICON_COLOR_16x16 :
				return iconColor16;

			case ICON_COLOR_32x32 :
				return iconColor32;

			case ICON_MONO_16x16 :
				return iconMono16;

			case ICON_MONO_32x32 :
				return iconMono32;
                        default:
                            return iconColor16;
		}

	}
}