package com.BwBE.game.desktop;

import com.BwBE.BWBHelpers.ActionResolver;

public class ActionResolverDesktop implements ActionResolver{
	
	@Override
	  public void toastMe(final String message) {
	    System.out.println(message);
	  }
}
