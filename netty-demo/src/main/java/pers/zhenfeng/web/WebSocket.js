let webSocket = new WebSocket("ws://localhost:8888");

webSocket.onopen = () => {
    webSocket.send("123");
};

webSocket.onmessage = () => {
    console.log("message");
};

webSocket.onerror = () => {
    console.log("error");
};

webSocket.onclose = () => {
    console.log("close");
};