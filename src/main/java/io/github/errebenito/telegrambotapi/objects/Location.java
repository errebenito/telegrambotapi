package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This object represents a point on the map.
 * 
 * @author Raúl Benito
 *
 */
public class Location {

	/**
	 * Longitude as defined by sender.
	 */
	@Expose
	@SerializedName(Constants.LONGITUDE)
	private Float longitude;

	/**
	 * Latitude as defined by sender.
	 */
	@Expose
	@SerializedName(Constants.LATITUDE)
	private Float latitude;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the Location will be constructed.
	 */
	public Location(final JsonObject object) {
		this.setLatitude(object.get(Constants.LATITUDE).getAsFloat());
		this.setLongitude(object.get(Constants.LONGITUDE).getAsFloat());
	}

	/**
	 * Class constructor.
	 */
	public Location() {
		this.setLatitude(null);
		this.setLongitude(null);
	}

	/**
	 * Accessor for the longitude.
	 * 
	 * @return the longitude
	 */
	public final Float getLongitude() {
		return this.longitude;
	}

	/**
	 * Mutator for the longitude.
	 * 
	 * @param lon
	 *            the longitude
	 */
	public final void setLongitude(final Float lon) {
		this.longitude = lon;
	}

	/**
	 * Accessor for the latitude.
	 * 
	 * @return the latitude
	 */
	public final Float getLatitude() {
		return this.latitude;
	}

	/**
	 * Mutator for the latitude.
	 * 
	 * @param lat
	 *            the latitude
	 */
	public final void setLatitude(final Float lat) {
		this.latitude = lat;
	}
}
