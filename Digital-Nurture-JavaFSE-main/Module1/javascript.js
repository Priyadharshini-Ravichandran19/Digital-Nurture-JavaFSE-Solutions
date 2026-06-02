console.log("Welcome to the Community Portal");

window.onload = function () {
    alert("NeighbourNet Community Portal Loaded Successfully!");
};

class Event {
    constructor(name, category, date, seats, location) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.seats = seats;
        this.location = location;
    }
}

Event.prototype.checkAvailability = function () {
    return this.seats > 0;
};

const events = [
    new Event("Music Fiesta", "Music", "2026-06-15", 30, "Chennai"),
    new Event("Food Carnival", "Food", "2026-06-20", 20, "Coimbatore"),
    new Event("Art Expo", "Art", "2026-07-10", 0, "Madurai"),
    new Event("City Marathon", "Sports", "2026-07-25", 50, "Salem")
];

const eventContainer = document.querySelector("#eventContainer");

function displayEvents(eventList) {

    eventContainer.innerHTML = "";

    eventList.forEach(event => {

        if (event.checkAvailability()) {

            const card = document.createElement("div");

            card.classList.add("dynamicCard");

            card.innerHTML = `
                <h3>${event.name}</h3>
                <p>Category : ${event.category}</p>
                <p>Date : ${event.date}</p>
                <p>Location : ${event.location}</p>
                <p>Seats Left : ${event.seats}</p>
                <button onclick="registerUser('${event.name}')">
                    Register
                </button>
            `;

            eventContainer.appendChild(card);
        }
    });
}

displayEvents(events);

function registerUser(eventName) {

    try {

        const selectedEvent = events.find(
            event => event.name === eventName
        );

        if (selectedEvent.seats > 0) {

            selectedEvent.seats--;

            alert(
                `Successfully registered for ${eventName}.
Seats remaining: ${selectedEvent.seats}`
            );

            displayEvents(events);

        } else {

            throw new Error("No seats available");
        }

    } catch (error) {

        alert(error.message);
    }
}

function addEvent(
    name = "Workshop",
    category = "General",
    date = "2026-08-01",
    seats = 25,
    location = "Chennai"
) {

    const newEvent = new Event(
        name,
        category,
        date,
        seats,
        location
    );

    events.push(newEvent);

    displayEvents(events);
}

function filterEventsByCategory(category, callback) {

    const filteredEvents = events.filter(
        event => event.category === category
    );

    callback(filteredEvents);
}

function filterCategory() {

    const selectedCategory =
        document.getElementById("categoryFilter").value;

    if (selectedCategory === "All") {

        displayEvents(events);

    } else {

        filterEventsByCategory(
            selectedCategory,
            displayEvents
        );
    }
}

function registrationTracker() {

    let totalRegistrations = 0;

    return function () {

        totalRegistrations++;

        console.log(
            `Total Registrations : ${totalRegistrations}`
        );
    };
}

const countRegistration = registrationTracker();

function searchEvents(event) {

    const searchValue =
        event.target.value.toLowerCase();

    const filtered = events.filter(
        eventItem =>
            eventItem.name
                .toLowerCase()
                .includes(searchValue)
    );

    displayEvents(filtered);
}

document
    .getElementById("searchBox")
    .addEventListener("keydown", searchEvents);

function showObjectEntries() {

    events.forEach(event => {

        console.log(
            Object.entries(event)
        );
    });
}

showObjectEntries();

const musicEvents = events.filter(
    event => event.category === "Music"
);

console.log(musicEvents);

const formattedCards = events.map(
    event => `Workshop on ${event.name}`
);

console.log(formattedCards);

function cancelRegistration(eventName) {

    const eventData = events.find(
        event => event.name === eventName
    );

    eventData.seats++;

    displayEvents(events);

    alert(
        `Registration cancelled for ${eventName}`
    );
}

function fetchEvents() {

    document.getElementById("loading").style.display =
        "block";

    fetch("https://jsonplaceholder.typicode.com/posts")

        .then(response => response.json())

        .then(data => {

            console.log(data);

            document.getElementById("loading").style.display =
                "none";
        })

        .catch(error => {

            console.log(error);

            document.getElementById("loading").style.display =
                "none";
        });
}

fetchEvents();

async function fetchEventsAsync() {

    try {

        document.getElementById("loading").style.display =
            "block";

        const response =
            await fetch(
                "https://jsonplaceholder.typicode.com/users"
            );

        const data = await response.json();

        console.log(data);

        document.getElementById("loading").style.display =
            "none";

    } catch (error) {

        console.log(error);

        document.getElementById("loading").style.display =
            "none";
    }
}

fetchEventsAsync();

function displayEventDetails(eventObj) {

    const {
        name,
        category,
        location
    } = eventObj;

    console.log(
        `${name} | ${category} | ${location}`
    );
}

displayEventDetails(events[0]);