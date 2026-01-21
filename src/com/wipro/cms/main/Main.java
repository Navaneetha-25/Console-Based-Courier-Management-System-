package com.wipro.cms.main;

import java.util.ArrayList;
import com.wipro.cms.entity.*;
import com.wipro.cms.service.CourierService;
import com.wipro.cms.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<CourierAgent> agents = new ArrayList<>();
		agents.add(new CourierAgent("A001", "Ramesh", true));
		agents.add(new CourierAgent("A002", "Deepa", true));
		ArrayList<CourierParcel> parcels = new ArrayList<>();
		ArrayList<ParcelUpdate> updates = new ArrayList<>();
		CourierService service = new CourierService(agents, parcels, updates);
		try {
			// Booking a parcel
			service.bookParcel(new CourierParcel("P001", "Suresh", "Priya", null, "BOOKED"));
			// Assigning parcel
			service.assignParcelToAgent("P001", "A001");
			// Adding tracking updates
			service.addParcelUpdate("P001", "2025-08-10", "Parcel received at warehouse");
			service.updateParcelStatus("P001", "IN_TRANSIT");
			service.addParcelUpdate("P001", "2025-08-11", "Parcel arrived at sorting facility");
			service.updateParcelStatus("P001", "OUT_FOR_DELIVERY");
			service.addParcelUpdate("P001", "2025-08-12", "Courier out for doorstep delivery");
			service.updateParcelStatus("P001", "DELIVERED");
			// History
			System.out.println("--- Parcel History ---");
			for (ParcelUpdate pu : service.getParcelHistory("P001")) {
				System.out.println(pu.getNotes());
			}
			// Agent parcels
			System.out.println("\n--- Parcels Assigned to A001 ---");
			service.displayAgentParcels("A001");
			// All parcels
			System.out.println("\n--- All Parcels ---");
			service.displayAllParcels();
		} catch (AgentNotFoundException | ParcelNotFoundException | ParcelOperationException ex) {
			System.out.println(ex);
		}
	}
}
