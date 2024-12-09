// FETCH DATA & DISPLAY TABLE
async function usersTableFunctions() {
  let pgData = [];

  // _____________________________________
  // Fetch data:
  async function fetchUsers() {
    try {
      const response = await fetch("/api/users");
      const users = await response.json();

      users.forEach((user) => {
        pgData.push(user);
      });
    } catch (error) {
      console.error("Error:", error);
    }
  }
  await fetchUsers();

  // _____________________________________
  // Display table:
  const usersDiv = document.getElementById("usersDiv");
  const sheetDiv = document.getElementById("sheetDiv");
  let toggleRow = true;

  function editDataSheet(user) {
    // let sheetToggle = true;

    function closeSheet() {
      // sheetToggle = false;
      const sheetElement = document.querySelector(".editSheet");
      if (sheetElement) {
        sheetElement.remove();
      }
    }

    function displaySheet() {
      let editSheetDiv = `
          <div class="editSheet w-[30vw] h-screen bg-zinc-100 absolute flex top-0 right-0">
            <p class="italic w-full">${user.firstName}</p>
            <button class="closeSheet">close</button>
          </div>
        `;

      sheetDiv.insertAdjacentHTML("beforeend", editSheetDiv);

      const closeButton = document.querySelector(".closeSheet");
      closeButton.addEventListener("click", closeSheet);
    }

    displaySheet();
  }

  pgData.forEach((user) => {
    if (toggleRow) {
      let usersDivData = `
        <div class="w-full flex flex-row mx-auto justify-between mb-2">
          <p class="italic w-full">${user.firstName}</p>
          <p class="italic w-full">${user.lastName}</p>
          <p class="italic w-full">${user.age}</p>
          <p class="italic w-full">${user.occupation}</p>
          <div class="flex w-full max-w-[50px] justify-end">
            <button data="${user.firstName}" class="w-8 h-8 text-xs rounded-full bg-zinc-800 text-white userEditButton">Edit</button>
          </div>
        </div>
      `;
      usersDiv.insertAdjacentHTML("afterend", usersDivData);
      const editButton = document.querySelector(".userEditButton");
      const data = editButton.getAttribute("data");
      editButton.addEventListener("click", function () {
        editDataSheet(user);
      });
    }
  });
}

window.onload = usersTableFunctions;

// FORM SCRIPT:
function submitForm(event) {
  event.preventDefault();

  const formData = {
    firstName: document.getElementById("firstName").value,
    lastName: document.getElementById("lastName").value,
    age: document.getElementById("age").value,
    occupation: document.getElementById("occupation").value,
  };

  fetch("/api/users", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(formData),
  })
    .then(() => {
      fetchUsers(); // Fetch the updated user list
      document.userForm.reset(); // Reset the form
    })
    .then(() => {
      console.log("reset form"), document.userForm.reset();
    })
    .catch((error) => console.error("Error:", error));
}
