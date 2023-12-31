package View;

import Handler.Validation;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Style {
	public static void LabelFillColorAndSize(Label l,String color,int size)
	{
		l.setStyle("-fx-text-fill:"+color);
		l.setFont(Font.font("Times New Roman", FontWeight.NORMAL, size));
		if(color.equals("red") || color.equals("RED")) {
			l.setVisible(false);
		}
	}
	public static void LabelFillColorAndSizeBold(Label l,String color,int size)
	{
		LabelFillColorAndSize(l,color,size);
		l.setFont(Font.font("Times New Roman", FontWeight.BOLD, size));
		
	}
	public static void ButtonFillColorAndSize(Button b,int size,int width,int height,int tb,int lr,String bgColor)
	{
		b.setTextFill(Color.WHITE);
		b.setFont(Font.font("Times New Roman", FontWeight.NORMAL, size));
		b.setPadding(new Insets(tb,lr,tb,lr));
		b.setPrefSize(width, height);
		b.setStyle("-fx-background-color:"+bgColor);

	}
	
	public static void ButtonSave(Button btnSave)
	{
		ButtonFillColorAndSize(btnSave,15,100,30,10,10,"green");
	}
	public static void ButtonCancel(Button btnCancel)
	{
		ButtonFillColorAndSize(btnCancel,15,100,30,10,10,"#f2f2f2");
		btnCancel.setTextFill(Color.BLACK);
	}
	public static void ButtonUpdate(Button btnUpdate)
	{
		ButtonFillColorAndSize(btnUpdate,15,100,30,10,10,"blue");
	}
	public static void VBoxFillColorAndSizeAndPadding(VBox vb,String color,int tbPad,int lrPad,int spacing)
	{
		vb.setStyle("-fx-background-color:"+color);
		vb.setPadding(new Insets(tbPad,lrPad,tbPad,lrPad));
		vb.setSpacing(spacing);
	}
	public static void HBoxFillColorAndSizeAndPadding(HBox hb,String color,int tbPad,int lrPad,int spacing)
	{
		hb.setStyle("-fx-background-color:"+color);
		hb.setPadding(new Insets(tbPad,lrPad,tbPad,lrPad));
		hb.setSpacing(spacing);
	}
	public static void HBoxWidthHeightSize(HBox hb,String color,int tbPad,int lrPad,int spacing,int width,int height)
	{
		HBoxFillColorAndSizeAndPadding(hb,color,tbPad,lrPad,spacing);
		hb.setPrefSize(width,height);
	}
	public static void BtnDisable(Button btnSave,Button btnUpdate)
	{
		btnSave.setDisable(true);
		btnUpdate.setDisable(true);
	}
	public static void LabelErrorAdd(VBox vb1,Label l1,String err,VBox vb2,Label l2)
	{
		vb1.getChildren().add(l1);
		vb2.getChildren().add(l2);
		l1.setText(err);
	}
	public static void LabelErrorRemove(VBox vb1,Label l1,VBox vb2,Label l2)
	{
		vb1.getChildren().remove(l1);
		vb2.getChildren().remove(l2);
	}
	public static void CheckEmail(TextField tEmail,Label lEmailError)
	{
		 if(!tEmail.getText().equals("") && !Validation.checkEmail(tEmail.getText()) && tEmail.getText().length()>50)
		 {
			 lEmailError.setVisible(true);
		 }
		 else
		 {
			 lEmailError.setVisible(false);
		 }
	}
	public static void CheckName(TextField tName,Label lNameError)
	{
		if(!tName.getText().equals("") && !Validation.checkName(tName.getText()))
		 {
			lNameError.setVisible(true);
		 }
		 else
		 {
			 lNameError.setVisible(false);
		 }
	}
	public static void CheckPassword(TextField tPassword,Label lPasswordError)
	{
		if(!tPassword.getText().equals("") && !Validation.checkPassword(tPassword.getText()))
		 {
			lPasswordError.setText(Validation.passwordError);
			lPasswordError.setVisible(true);
		 }
		 else
		 {
			 lPasswordError.setVisible(false);
		 }
	}
	public static void CheckAddress(TextArea taAdd,Label lAddError)
	{
		if(!taAdd.getText().equals("") && taAdd.getText().length()<4)
		 {
			lAddError.setVisible(true);
		 }
		 else
		 {
			 lAddError.setVisible(false);
		 }
	}
	public static void CheckPhoneNo(TextField tPhoneNo,Label lPhoneNoError)
	{
		if(!tPhoneNo.getText().equals("") && !Validation.checkPhone(tPhoneNo.getText()))
		 {
			lPhoneNoError.setVisible(true);
		 }
		 else
		 {
			 lPhoneNoError.setVisible(false);
		 }
	}
	public static void CheckDate(TextField tDate,Label lDateError)
	{
		if(!tDate.getText().equals("") && !Validation.checkDate(tDate.getText()))
		 {
			lDateError.setVisible(true);
		 }
		 else
		 {
			 lDateError.setVisible(false);
		 }
	}
	public static boolean CheckAllValid(TextField tEmail,TextField tName,TextField tj,TextField tdob,TextField tPassword,TextArea taAdd,TextField tPhone)
	{
		if(Validation.checkEmail(tEmail.getText()) && tEmail.getText().length()<100 && Validation.checkName(tName.getText()) && tName.getText().length()<50 && Validation.checkDate(tj.getText()) && Validation.checkDate(tdob.getText()) &&  Validation.checkPassword(tPassword.getText()) && taAdd.getText().length()>3 && taAdd.getText().length()<50 && Validation.checkPhone(tPhone.getText()))
		{
			return true;
		}
		return false;
	}
	public static void GpFillColorAndSizeAndPadding(GridPane gp,int tbPad,int lrPad,int hGap,int vGap,String color)
	{
		gp.setStyle("-fx-background-color:"+color);
		gp.setHgap(hGap);
		gp.setVgap(vGap);
		gp.setPadding(new Insets(tbPad,lrPad,tbPad,lrPad));
	}
	public static void BtnAdd(Button btnAdd)
	{
		ButtonFillColorAndSize(btnAdd,18,170,50,10,10,"green");

	}
	public static void BtnSus(Button btnSus)
	{
		ButtonFillColorAndSize(btnSus,18,230,50,10,10,"orange");
	}
	public static void ChildNodeAddToVBox(VBox parentVBox,HBox childHB,GridPane childGp)
	{
		parentVBox.getChildren().addAll(childHB,childGp);
		parentVBox.setStyle("-fx-background-color:#f9f9f9;-fx-border-color:grey;-fx-border-width:1;-fx-border-style:solid;");

	}
	public static void TextFieldFill(TextField textField,String promptText,int height,int fontSize)
	{
		textField.setPromptText(promptText);
		textField.setPrefHeight(height);
		textField.setFont(Font.font(fontSize));
	}
	public static void TextFieldFill(TextField textField,int width,String text)
	{
		textField.setPrefWidth(width);
		textField.setText(text);
	}
}
