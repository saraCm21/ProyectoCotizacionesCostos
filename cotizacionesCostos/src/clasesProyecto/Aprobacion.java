package clasesProyecto;

public class Aprobacion {
		
		private String id;
		String aproval;
		String aprovalBoss;
		
		public Aprobacion(String id) {
			this.id = id;
		}

		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getAproval() {
			return aproval;
		}
		
		public void setAproval(String aproval) {
			this.aproval = aproval;
		}
		
		public String getAprovalBoss() {
			return aprovalBoss;
		}
		
		public void setAprovalBoss(String aprovalBoss) {
			this.aprovalBoss = aprovalBoss;
		}

		@Override
		public String toString() {
			return "";
		}
	
	
}
