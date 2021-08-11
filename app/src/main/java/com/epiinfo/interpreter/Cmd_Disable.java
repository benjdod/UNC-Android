package com.epiinfo.interpreter;

import com.epiinfo.droid.FormLayoutManager;

import goldengine.java.Reduction;
import goldengine.java.Token;
import android.view.View;
import android.widget.EditText;

public class Cmd_Disable implements ICommand {

	private Token identifierList;
	private FormLayoutManager controlHelper;
	
	public Cmd_Disable(Reduction reduction, FormLayoutManager controlHelper)
	{
		this.controlHelper = controlHelper;
		identifierList = reduction.getToken(1);
	}
	
	public void Execute()
	{
		Reduction idReduction = (Reduction)identifierList.getData();
		Token identifier = idReduction.getToken(0);
		System.out.println(".........Disabling " + identifier.getData() + " field");
		View control = controlHelper.controlsByName.get(identifier.getData());
		control.setEnabled(false);
	}
	
}
