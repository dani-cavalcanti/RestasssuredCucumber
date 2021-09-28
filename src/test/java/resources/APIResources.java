package resources;

public enum APIResources {
    AddPlaceAPI("/maps/api/place/add/json"),
    DeletePlaceAPI("/maps/api/place/delete/json"),
    viaCEP("/ws/12246870/json"),
    viaCEP1("/ws/12246870/json"),
    viaCEP2("/ws/12246873/json");
    private final String resource;

    APIResources(final String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
