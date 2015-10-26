package com.ranga.jsf.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class ValidationPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("ValidationPhaseListener.afterPhase "
				+ event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("ValidationPhaseListener.beforePhase"
				+ event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.PROCESS_VALIDATIONS;
	}

}
