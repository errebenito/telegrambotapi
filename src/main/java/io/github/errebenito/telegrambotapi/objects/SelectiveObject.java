package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents keyboards that can be shown to specific users.
 * @author Raúl Benito
 *
 */
public class SelectiveObject {

	/**
	 * Use this parameter if you want to show the keyboard to specific users
	 * only. Optional.
	 */
	@Expose
	@SerializedName(Constants.SELECTIVE)
	private Boolean selective;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the SelectiveObject will be
	 *            constructed.
	 */
	public SelectiveObject(final JsonObject object) {
		if (object.has(Constants.SELECTIVE)) {
			this.setSelective(object.get(Constants.SELECTIVE).getAsBoolean());
		} 
	}

	/**
	 * 
	 * Class constructor.
	 */
	public SelectiveObject() {
		this.setSelective(null);
	}
	
	/**
	 * Accessor for the selective object field.
	 * 
	 * @return <em>true</em> if the keyboard can be shown to certain users only;
	 * 		   <em>false</em> otherwise
	 */
	public final Boolean getSelective() {
		return this.selective;
	}

	/**
	 * Mutator for the selective object field.
	 * 
	 * @param select
	 *            <em>true</em> if the keyboard can be shown to certain users 
	 *            only; <em>false</em> otherwise
	 */
	public final void setSelective(final Boolean select) {
		this.selective = select;
	}
}
