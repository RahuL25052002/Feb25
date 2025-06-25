const API_URL = "http://localhost:3000/users";

const userForm = document.getElementById('userForm');
const userTable = document.getElementById('userTable');
const userIdInput = document.getElementById('userId');
const nameInput = document.getElementById('name');
const emailInput = document.getElementById('email');

// 🔄 Load all users
async function loadUsers() {
  const res = await fetch(API_URL);
  const users = await res.json();

  userTable.innerHTML = '';
  users.forEach(user => {
    userTable.innerHTML += `
      <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>
          <button class="btn btn-sm btn-warning" onclick="editUser(${user.id})">Edit</button>
          <button class="btn btn-sm btn-danger" onclick="deleteUser(${user.id})">Delete</button>
        </td>
      </tr>
    `;
  });
}

// ➕ Create or ✏️ Update User
userForm.addEventListener('submit', async (e) => {
  e.preventDefault();

  const id = userIdInput.value;
  const user = {
    name: nameInput.value,
    email: emailInput.value
  };

  if (id) {
    // PUT = Update
    await fetch(`${"http://localhost:3000/users"}/${id}`, {
      method: 'PUT',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(user)
    });
  } else {
    // POST = Create
    await fetch("http://localhost:3000/users", {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(user)
    });
  }

  userForm.reset();
  loadUsers();
});

// ✏️ Edit user
async function editUser(id) {
  const res = await fetch(`${API_URL}/${id}`);
  const user = await res.json();
  userIdInput.value = user.id;
  nameInput.value = user.name;
  emailInput.value = user.email;
}

// ❌ Delete user
async function deleteUser(id) {
  if (confirm("Are you sure to delete?")) {
    await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
    loadUsers();
  }
}

loadUsers(); // Initial load
