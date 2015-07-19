package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a user's profile pictures.
 * 
 * @author Raúl Benito
 *
 */
public class UserProfilePhotos {


	


	/**
	 * Total number of profile pictures the target user has.
	 */
	@Expose
	@SerializedName(Constants.TOTAL_COUNT)
	private Integer totalCount;

	/**
	 * Requested profile pictures (in up to 4 sizes each).
	 */
	@Expose
	@SerializedName(Constants.PHOTOS)
	private PhotoSize[][] photos;

	/**
	 * 
	 * Class constructor.
	 */
	public UserProfilePhotos() {
		this.setTotalCount(0);
		this.setPhotos(new PhotoSize[Constants.MAX_SIZES][]);
	}
	
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the UserProfilePhotos will be
	 *            constructed.
	 */
	public UserProfilePhotos(final JsonObject object) {
		this.setTotalCount(object.get(Constants.TOTAL_COUNT).getAsInt());
		final PhotoSize[][] profilePhotos = 
				new PhotoSize[Constants.MAX_SIZES][];
		for (int i = 0; i < Constants.MAX_SIZES; i++) {
			final int loopSize = object.get(Constants.PHOTOS).getAsJsonArray()
					.get(i).getAsJsonArray().size();
			for (int j = 0; j < loopSize; j++) {
				profilePhotos[i][j].setFileId(object
			            .get(Constants.PHOTOS).getAsJsonArray().get(i)
			            .getAsJsonArray().get(j)
			            .getAsJsonObject().get(Constants.FILE_ID)
			            .getAsString());
				profilePhotos[i][j].setFileSize(object
			            .get(Constants.PHOTOS).getAsJsonArray().get(i)
			            .getAsJsonArray().get(j)
			            .getAsJsonObject().get(Constants.FILE_SIZE)
			            .getAsInt());
				profilePhotos[i][j].setHeight(object
						.get(Constants.PHOTOS).getAsJsonArray().get(i)
						.getAsJsonArray().get(j)
			            .getAsJsonObject().get(Constants.HEIGHT)
			            .getAsInt());
				profilePhotos[i][j].setWidth(object
						.get(Constants.PHOTOS).getAsJsonArray().get(i)
               		 	.getAsJsonArray().get(j)
               		 	.getAsJsonObject().get(Constants.WIDTH)
               		 	.getAsInt());				
			}
			this.setPhotos(profilePhotos);
		}
	}

	/**
	 * Accessor for the total number of profile pictures the target user has.
	 * 
	 * @return the total number of profile pictures the target user has
	 */
	public final Integer getTotalCount() {
		return this.totalCount;
	}

	/**
	 * Mutator for the total number of profile pictures the target user has.
	 * 
	 * @param count
	 *            the total number of profile pictures the target user has
	 */
	public final void setTotalCount(final Integer count) {
		this.totalCount = count;
	}

	/**
	 * Accessor for the requested profile pictures.
	 * 
	 * @return the requested profile pictures
	 */
	public final PhotoSize[][] getPhotos() {
		final PhotoSize[][] result = 
				new PhotoSize[photos.length][];
		for (int i = 0; i < photos.length; i++) {
			System.arraycopy(photos[i], 0, result[i], 0, photos[0].length);
		}
		return result;
	}

	/**
	 * Mutator for the requested profile pictures.
	 * 
	 * @param pictures
	 *            the requested profile pictures
	 */
	public final void setPhotos(final PhotoSize[]... pictures) {
		for (int i = 0; i < photos.length; i++) {
			System.arraycopy(pictures[i], 0, photos[i], 0, pictures[0].length);
		}
	}

}
