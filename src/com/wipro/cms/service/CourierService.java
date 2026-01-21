package com.wipro.cms.service;

import java.util.ArrayList;
import java.time.LocalDate;
import com.wipro.cms.entity.CourierAgent;
import com.wipro.cms.entity.CourierParcel;
import com.wipro.cms.entity.ParcelUpdate;
import com.wipro.cms.util.AgentNotFoundException;
import com.wipro.cms.util.ParcelNotFoundException;
import com.wipro.cms.util.ParcelOperationException;

public class CourierService {
	private ArrayList<CourierAgent> agents;
	private ArrayList<CourierParcel> parcels;
	private ArrayList<ParcelUpdate> updates;

	public CourierService(ArrayList<CourierAgent> agents, ArrayList<CourierParcel> parcels,
			ArrayList<ParcelUpdate> updates) {
		super();
		this.agents = agents;
		this.parcels = parcels;
		this.updates = updates;
	}

	public CourierAgent findAgent(String agentId) throws AgentNotFoundException {
		for (CourierAgent agent : agents) {
			if (agent.getAgentId().equals(agentId)) {
				return agent;
			}
		}
		throw new AgentNotFoundException("Agent with ID: " + agentId + " is not found");
	}

	public void bookParcel(CourierParcel parcel) {
		String updateId = "U" + (updates.size() + 1);
		String todayDate = LocalDate.now().toString();

		ParcelUpdate update = new ParcelUpdate(updateId, parcel.getParcelId(), todayDate, "Parcel booked successfully");
		updates.add(update);

		parcel.setStatus("BOOKED");
		parcels.add(parcel);
	}

	public CourierParcel findParcel(String parcelId) throws ParcelNotFoundException {
		for (CourierParcel parcel : parcels) {
			if (parcel.getParcelId().equals(parcelId)) {
				return parcel;
			}
		}
		throw new ParcelNotFoundException("Parcel with ID: " + parcelId + " is not found");
	}

	public void assignParcelToAgent(String parcelId, String agentId)
			throws AgentNotFoundException, ParcelNotFoundException {
		CourierAgent agent = findAgent(agentId);
		CourierParcel parcel = findParcel(parcelId);

		parcel.setAgentId(agent.getAgentId());
		parcel.setStatus("IN_TRANSIT");

		String updateId = "U" + (updates.size() + 1);
		String todayDate = LocalDate.now().toString();

		ParcelUpdate update = new ParcelUpdate(updateId, parcelId, todayDate,
				"Parcel assigned to agent " + agent.getName() + " and is now in transit");

		updates.add(update);
	}

	public void updateParcelStatus(String parcelId, String newStatus) throws ParcelNotFoundException {

		CourierParcel parcel = findParcel(parcelId);
		parcel.setStatus(newStatus);

		String updateId = "U" + (updates.size() + 1);
		String todayDate = LocalDate.now().toString();

		ParcelUpdate update = new ParcelUpdate(updateId, parcelId, todayDate, "Parcel status updated to " + newStatus);
		updates.add(update);
	}

	public void addParcelUpdate(String parcelId, String date, String notes)
			throws ParcelNotFoundException, ParcelOperationException {

		CourierParcel parcel = findParcel(parcelId);
		if (notes == null || notes.trim().isEmpty()) {
			throw new ParcelOperationException("Update notes cannot be empty");
		}
		String updateId = "U" + (updates.size() + 1);
		ParcelUpdate update = new ParcelUpdate(updateId, parcel.getParcelId(), date, notes);

		updates.add(update);
	}

	public ArrayList<ParcelUpdate> getParcelHistory(String parcelId) throws ParcelNotFoundException {
		findParcel(parcelId);
		ArrayList<ParcelUpdate> history = new ArrayList<>();
		for (ParcelUpdate update : updates) {
			if (update.getParcelId().equals(parcelId)) {
				history.add(update);
			}
		}
		return history;
	}

	public void cancelParcel(String parcelId) throws ParcelNotFoundException {
		CourierParcel parcel = findParcel(parcelId);
		parcels.remove(parcel);
		ArrayList<ParcelUpdate> toRemove = new ArrayList<>();
		for (ParcelUpdate update : updates) {
			if (update.getParcelId().equals(parcelId)) {
				toRemove.add(update);
			}
		}
		updates.removeAll(toRemove);
	}

	public void displayAgentParcels(String agentId) {

		System.out.println("Parcels assigned to agent " + agentId + ":");

		boolean found = false;

		for (CourierParcel parcel : parcels) {
			if (agentId.equals(parcel.getAgentId())) {
				System.out.println("Parcel ID: " + parcel.getParcelId() + ", Sender: " + parcel.getSenderName()
						+ ", Receiver: " + parcel.getReceiverName() + ", Status: " + parcel.getStatus());
				found = true;
			}
		}

		if (!found) {
			System.out.println("No parcels assigned to this agent.");
		}
	}

	public void displayAllParcels() {

		System.out.println("All Parcels:");

		if (parcels.isEmpty()) {
			System.out.println("No parcels found.");
			return;
		}

		for (CourierParcel parcel : parcels) {
			System.out.println("Parcel ID: " + parcel.getParcelId() + ", Sender: " + parcel.getSenderName()
					+ ", Receiver: " + parcel.getReceiverName() + ", Agent ID: " + parcel.getAgentId() + ", Status: "
					+ parcel.getStatus());
		}
	}

}
