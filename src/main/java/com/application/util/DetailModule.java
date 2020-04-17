package com.application.util;

import org.springframework.stereotype.Component;

@Component
public class DetailModule {

	
	private boolean moduleAccueil;
	private boolean moduleConsultation;
	
	
	public DetailModule() {
		setModuleAccueil(false);
		setModuleConsultation(false);
	}
	
	public void reset() {
		this.moduleAccueil = false;
		this.moduleConsultation = false;
	}
	
	
	// -------------------- Getter ----------------------
	
	public boolean isModuleAccueil() {
		return moduleAccueil;
	}
	public boolean isModuleConsultation() {
		return moduleConsultation;
	}
	
	//--------------------- Setter -----------------------
	
	public void setModuleAccueil(boolean moduleAccueil) {
		reset();
		this.moduleAccueil = moduleAccueil;
	}
	public void setModuleConsultation(boolean moduleConsultation) {
		reset();
		this.moduleConsultation = moduleConsultation;
	}
}
