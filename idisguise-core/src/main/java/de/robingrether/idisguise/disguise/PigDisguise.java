package de.robingrether.idisguise.disguise;

/**
 * Represents a disguise as a pig.
 * 
 * @since 3.0.1
 * @author RobinGrether
 */
public class PigDisguise extends AgeableDisguise {
	
	private boolean saddled;
	
	/**
	 * Creates an instance.
	 * 
	 * @since 4.0.1
	 */
	public PigDisguise() {
		this(true, false);
	}
	
	/**
	 * Creates an instance.
	 * 
	 * @since 3.0.1
	 * @param adult should the disguise be an adult
	 * @param saddled should the disguise be saddled
	 */
	public PigDisguise(boolean adult, boolean saddled) {
		super(DisguiseType.PIG, adult);
		this.saddled = saddled;
	}
	
	/**
	 * Gets whether the pig is saddled.
	 * 
	 * @since 3.0.1
	 * @return <code>true</code> if the pig is saddled
	 */
	public boolean isSaddled() {
		return saddled;
	}
	
	/**
	 * Sets whether the pig is saddled.
	 * 
	 * @since 3.0.1
	 * @param saddled should the pig be saddled
	 */
	public void setSaddled(boolean saddled) {
		this.saddled = saddled;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return String.format("%s; %s", super.toString(), saddled ? "saddled" : "not-saddled");
	}
	
	static {
		Subtypes.registerSimpleSubtype(PigDisguise.class, disguise -> disguise.setSaddled(true), "saddled");
		Subtypes.registerSimpleSubtype(PigDisguise.class, disguise -> disguise.setSaddled(false), "not-saddled");
	}
	
}