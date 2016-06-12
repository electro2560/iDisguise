package de.robingrether.idisguise.disguise;

import java.util.Locale;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Represents a disguise as an item stack.
 * 
 * @since 5.1.1
 * @author RobinGrether
 */
public class ItemDisguise extends ObjectDisguise {
	
	private static final long serialVersionUID = -4607689524782164382L;
	private ItemStack itemStack;
	
	/**
	 * Creates an instance.<br>
	 * The default item stack is one stone.
	 * 
	 * @since 5.1.1
	 */
	public ItemDisguise() {
		this(new ItemStack(Material.STONE, 1, (short)0));
	}
	
	/**
	 * Creates an instance.
	 * 
	 * @since 5.1.1
	 * @param itemStack the displayed item stack
	 * @throws IllegalArgumentException if the item stack is <code>null</code>
	 */
	public ItemDisguise(ItemStack itemStack) {
		super(DisguiseType.ITEM);
		if(itemStack == null) {
			throw new IllegalArgumentException("Item stack must not be null");
		}
		this.itemStack = itemStack;
	}
	
	/**
	 * Gets the displayed item stack.
	 * 
	 * @since 5.1.1
	 * @return a copy of the displayed item stack
	 */
	public ItemStack getItemStack() {
		return itemStack.clone();
	}
	
	/**
	 * Sets the displayed item stack.
	 * 
	 * @since 5.1.1
	 * @param itemStack the displayed item stack
	 * @throws IllegalArgumentException if the item stack is null
	 */
	public void setItemStack(ItemStack itemStack) {
		if(itemStack == null) {
			throw new IllegalArgumentException("Item stack must not be null");
		}
		this.itemStack = itemStack;
	}
	
	/**
	 * Gets the material.
	 * 
	 * @since 5.3.1
	 * @return the material
	 */
	public Material getMaterial() {
		return itemStack.getType();
	}
	
	/**
	 * Sets the material.
	 * 
	 * @since 5.3.1
	 * @param material the material
	 */
	public void setMaterial(Material material) {
		itemStack.setType(material);
	}
	
	/**
	 * Gets the data value.
	 * 
	 * @since 5.3.1
	 * @return the data value
	 */
	public int getData() {
		return itemStack.getDurability();
	}
	
	/**
	 * Sets the data value.
	 * 
	 * @since 5.3.1
	 * @param data the data value
	 */
	public void setData(int data) {
		itemStack.setDurability((short)data);
	}
	
	/**
	 * Gets the amount.
	 * 
	 * @since 5.3.1
	 * @return the amount
	 */
	public int getAmount() {
		return itemStack.getAmount();
	}
	
	/**
	 * Sets the amount.
	 * 
	 * @since 5.3.1
	 * @param amount the amount
	 */
	public void setAmount(int amount) {
		itemStack.setAmount(amount);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ItemDisguise clone() {
		return new ItemDisguise(itemStack.clone());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object object) {
		return super.equals(object) && object instanceof ItemDisguise && ((ItemDisguise)object).itemStack.equals(itemStack);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return super.toString() + "; " + itemStack.getType().name().toLowerCase(Locale.ENGLISH).replace('_', '-') + "; " + Short.toString(itemStack.getDurability()) + "; " + (itemStack.getAmount() < 2 ? "single" : itemStack.getAmount() < 17 ? "double" : itemStack.getAmount() < 33 ? "triple" : itemStack.getAmount() < 49 ? "quadruple" : "quintuple");
	}
	
	static {
		for(Material material : Material.values()) {
			Subtypes.registerSubtype(ItemDisguise.class, "setMaterial", material, material.name().toLowerCase(Locale.ENGLISH).replace('_', '-'));
		}
		for(int i = 0; i < 256; i++) {
			Subtypes.registerSubtype(ItemDisguise.class, "setData", i, Integer.toString(i));
		}
		Subtypes.registerSubtype(ItemDisguise.class, "setAmount", 1, "single");
		Subtypes.registerSubtype(ItemDisguise.class, "setAmount", 2, "double");
		Subtypes.registerSubtype(ItemDisguise.class, "setAmount", 17, "triple");
		Subtypes.registerSubtype(ItemDisguise.class, "setAmount", 33, "quadruple");
		Subtypes.registerSubtype(ItemDisguise.class, "setAmount", 49, "quintuple");
	}
	
}