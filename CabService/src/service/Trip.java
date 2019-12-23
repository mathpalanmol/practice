package service;

public class Trip {
		Cab cab;
		Location start;
		Location dest;
		String id;

		public Trip(Cab cab, Location start, Location dest) {
			super();
			this.cab = cab;
			this.start = start;
			this.dest = dest;
		}

		private String generateTripId() {
			return id;
		}

		public String getId() {
			return id;
		}

	}
