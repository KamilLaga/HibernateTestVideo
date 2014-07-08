package be.vdab.keys;

import java.io.Serializable;

import javax.persistence.Column;

public class ReservatieKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="ReservatieDatum")
	protected String reservatieDatum;
	protected int klantNr;
	protected int filmNr;

	public ReservatieKey() {
	}

	public int hashCode() {
		return (filmNr + klantNr + reservatieDatum).toUpperCase().hashCode();
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof ReservatieKey)) { return false; }
		ReservatieKey reservatieKey = (ReservatieKey) obj;
		return (reservatieKey.filmNr == filmNr &&
				reservatieKey.klantNr == klantNr &&
				reservatieKey.reservatieDatum.equalsIgnoreCase(reservatieDatum));
	}
}