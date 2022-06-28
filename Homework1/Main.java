package com.HW1;
/**
 *
 * Driver Class
 */
public class Main {

    public static void main(String[] args) {
    Street myStreet = new Street();
    System.out.println("**********STREET SIMULATION**********");
    System.out.println("~Test Case 1~");
    System.out.println("Adding Some building to Street and Display");
    House myTestHouse1 = new House();
    myTestHouse1.setPosition(1);
    myTestHouse1.setHeight(4);
    myTestHouse1.setLength(4);
    myTestHouse1.setOwner("Blue");
    myTestHouse1.setNumberOfRooms(3);
    myStreet.add(myTestHouse1);
    Playground myTestPlayground1 = new Playground();
    myTestPlayground1.setPosition(3);
    myTestPlayground1.setLength(6);
    myStreet.add(myTestPlayground1);
    myStreet.displayBuildings();
    System.out.println("~Test Case 2~");
    System.out.println("Try to add a build but there is no enough space for it.");
    Office myTestOffice1 = new Office();
    myTestOffice1.setPosition(9);
    myTestOffice1.setLength(15);
    myTestOffice1.setHeight(4);
    myTestOffice1.setJobType("Software Office");
    myTestOffice1.setOwner("Bill Gates");
    myStreet.add(myTestOffice1);
    System.out.println("~Test Case 3~");
    System.out.println("Increase the Total Length and added Office after that display total remaining length.");
    myStreet.settotalLength();
    myStreet.add(myTestOffice1);
    myStreet.displayRemainingLength();
    System.out.println("~Test Case 4~");
    System.out.println("Create Market added it after that Display Ratio of Length of playgrounds in the street");
    Market myTestMarket1 = new Market();
    myTestMarket1.setPosition(12);
    myTestMarket1.setLength(9);
    myTestMarket1.setHeight(8);
    myTestMarket1.setOpeningTime(1030);
    myTestMarket1.setClosingTime(2230);
    myTestMarket1.setOwner("Elon Musk");
    myStreet.add(myTestMarket1);
    myStreet.displayNumberAndRationOfPlaygrounds();
    System.out.println("~Test Case 5~");
    System.out.println("Again Display Buildings");
	myStreet.displayBuildings();
	System.out.println("~Test Case 6~");
	System.out.println("Display Skyline Silhouette");
	myStreet.displaySkylineSilhouette();
	System.out.println("~Test Case 7~");
	System.out.println("Add some playgrounds, office and home. Display the list");
	Playground myTestPlayground2 = new Playground();
	myTestPlayground2.setPosition(18);
	myTestPlayground2.setLength(7);
	myStreet.addByIndex(4,myTestPlayground2);
	Office myTestOffice2 = new Office();
	myTestOffice2.setPosition(30);
	myTestOffice2.setLength(10);
	myTestOffice2.setHeight(10);
	myTestOffice2.setJobType("Change Office");
	myTestOffice2.setOwner("Volodimir Zelenski");
	myStreet.addByIndex(6,myTestOffice2);
	House myTestHouse2 = new House();
	myTestHouse2.setPosition(32);
	myTestHouse2.setHeight(5);
	myTestHouse2.setLength(5);
	myTestHouse2.setOwner("Red");
	myTestHouse2.setNumberOfRooms(6);
	myStreet.addByIndex(5,myTestHouse2);
	myStreet.displayBuildings();
	System.out.println("~Test Case 8~");
	System.out.println("Display Length of Street occupied by the Markets");
	myStreet.totalLengthOfSpecificBuildings();
	System.out.println("~Test Case 9~");
	System.out.println("Display new Skyline Silhouette");
	myStreet.displaySkylineSilhouette();
	System.out.println("~Test Case 10~");
	System.out.println("Delete slot 5th House and calculate length of occupied by the House ");
	myStreet.delete(5);
	myStreet.totalLengthOfSpecificBuildings();
	System.out.println("~Test Case 11~");
	System.out.println("Test focus functions");
	System.out.println(myStreet.streetArray[0].focus());
	System.out.println(myStreet.streetArray[1].focus());
	System.out.println(myStreet.streetArray[2].focus());
	System.out.println(myStreet.streetArray[3].focus());
	System.out.println(myStreet.streetArray[4].focus());
	System.out.println(myStreet.streetArray[6].focus());
	}

}
