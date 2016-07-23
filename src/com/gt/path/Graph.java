package com.gt.path;

import java.util.List;

public class Graph {
  private final List<Location> locations;
  private final List<Orbit> orbits;

  public Graph(List<Location> locations, List<Orbit> orbits) {
    this.locations = locations;
    this.orbits = orbits;
  }

  public List<Location> getLocations() {
    return locations;
  }

  public List<Orbit> getOrbits() {
    return orbits;
  }
}
  
  
