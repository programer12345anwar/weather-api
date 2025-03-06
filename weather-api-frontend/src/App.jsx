
import './App.css';
import React, { useState } from "react";
import axios from "axios";

function App() {
    const [city, setCity] = useState("");
    const [weather, setWeather] = useState(null);
    const [error, setError] = useState("");

    const fetchWeather = async () => {
        try {
            const response = await axios.get(
                `http://localhost:8081/api/v1/weather/?city=${city}`
            );
            setWeather(response.data);
            setError("");
        } catch (err) {
            setError("City not found or server error."+ err);
            setWeather(null);
        }
    };

    return (
        <div className="flex flex-col items-center justify-center min-h-screen bg-gradient-to-r from-blue-500 to-purple-600 text-white">
            <h1 className="text-3xl font-bold mb-5">Weather App</h1>
            
            <div className="flex space-x-2">
                <input
                    type="text"
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                    placeholder="Enter city name..."
                    className="px-4 py-2 rounded-lg border-none outline-none text-gray-800"
                />
                <button
                    onClick={fetchWeather}
                    className="px-4 py-2 bg-blue-700 hover:bg-blue-800 text-white rounded-lg transition"
                >
                    Get Weather
                </button>
            </div>

            {error && <p className="text-red-500 mt-4">{error}</p>}

            {weather && (
                <div className="mt-6 p-6 bg-white bg-opacity-20 backdrop-blur-md rounded-lg shadow-lg w-80 text-center">
                    <h2 className="text-2xl font-bold">{weather.location.name}</h2>
                    <p className="text-lg">{weather.location.country}</p>
                    <p className="text-lg">{weather.location.region}</p>
                    <p className="text-lg">{weather.location.localtime}</p>
                    
                    <div className="mt-4">
                        <p className="text-xl font-semibold">
                            🌡 Temperature: {weather.current.temperature}°C
                        </p>
                        <p className="text-lg">🌤 {weather.current.weather_descriptions[0]}</p>
                        <p className="text-lg">🤒 Feels Like: {weather.current.feelslike}°C</p>
                        <p className="text-lg">💧 Humidity: {weather.current.humidity}%</p>
                        <p className="text-lg">🌬 Wind Speed: {weather.current.wind_speed} km/h</p>
                        <p className="text-lg">🌪 Pressure: {weather.current.pressure} hPa</p>
                        <p className="text-lg">🌞 UV Index: {weather.current.uv}</p>
                    </div>
                </div>
            )}
        </div>
    );
}

export default App;


 /*
import './App.css'
import React, { useState } from "react";
import axios from "axios";

function App() {
    const [city, setCity] = useState("");
    const [weather, setWeather] = useState(null);
    const [error, setError] = useState("");

    const fetchWeather = async () => {
        try {
            const response = await axios.get(
                `http://localhost:8081/api/v1/weather/?city=${city}`
            );
            setWeather(response.data);
            setError("");
        // eslint-disable-next-line no-unused-vars
        } catch (err) {
            setError("City not found or server error.");
            setWeather(null);
        }
    };

    return (
        <div style={{ textAlign: "center", marginTop: "50px" }}>
            <h1>Weather App</h1>
            <input
                type="text"
                value={city}
                onChange={(e) => setCity(e.target.value)}
                placeholder="Enter city name"
            />
            <button onClick={fetchWeather}>Get Weather</button>
            {error && <p style={{ color: "red" }}>{error}</p>}
            {weather && (
                <div>
                    <h2>{weather.location.name}</h2>
                    <p>Temperature: {weather.current.temperature}°C</p>
                    <p><strong>Condition:</strong> {weather.current.weather_descriptions[0]}</p>
                    <p><strong>Feels Like:</strong> {weather.current.feelslike}°C</p>
                    <p><strong>Humidity:</strong> {weather.current.humidity}%</p>
                    <p><strong>Wind Speed:</strong> {weather.current.wind_speed} km/h</p>
                </div>
            )}
        </div>
    );
}

export default App;
*/

