const socket = new SockJS("http://localhost:8080/chat");
const stompClient = Stomp.over(socket);

stompClient.connect({}, (frame) => {
  console.log("Connected: " + frame);
  stompClient.subscribe("/topic/messages", (messageOutput) => {
    const msg = JSON.parse(messageOutput.body);
    showMessage(msg.sender + ": " + msg.content);
  });
});

function sendMessage() {
  const sender = localStorage.getItem("username");
  const content = document.getElementById("message").value;

  if (content.trim() !== "") {
    stompClient.send("/app/sendMessage", {}, JSON.stringify({ sender, content }));
    document.getElementById("message").value = "";
  }
}

function showMessage(message) {
  const chatBox = document.getElementById("chatBox");
  const p = document.createElement("p");
  p.textContent = message;
  chatBox.appendChild(p);
}
