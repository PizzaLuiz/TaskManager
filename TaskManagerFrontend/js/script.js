const form = document.getElementById('task-form');
const table = document.getElementById('task-table');

function loadTasks() {
    fetch('http://localhost:8080/task')
        .then(response => response.json())
        .then(tasks => {
            table.tBodies[0].innerHTML = '';

            tasks.forEach(task => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${task.title}</td>
                    <td>
                    <select onchange="editTask(${task.id}, this.value)">
                        <option value="pendente" ${task.status === 'pendente' ? 'selected' : ''}>pendente</option>
                        <option value="em andamento" ${task.status === 'em andamento' ? 'selected' : ''}>em andamento</option>
                        <option value="concluida" ${task.status === 'concluida' ? 'selected' : ''}>Concluída</option>
                    </select>
                    </td>
                    <td>
                        <button class="btn-action" onclick="deleteTask(${task.id})">
                            <span class="material-symbols-outlined">
                                delete
                            </span>
                        </button>
                    </td>
                `;
                table.tBodies[0].appendChild(row);
            });
        });
}

function addTask(event) {
    event.preventDefault();

    const inputTask = document.querySelector('.input-task');
    const taskTitle = inputTask.value;

    if (taskTitle.trim() !== '') {
        const task = {
            title: taskTitle,
            status: 'pendente'
        };

        fetch('http://localhost:8080/task', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(task)
        })
            .then(response => response.json())
            .then(newTask => {
                inputTask.value = '';
                loadTasks();
            });
    }
}

function editTask(taskId, status) {

    fetch(`http://localhost:8080/task/${taskId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({status: status})
    })
        .then(response => response.json())
        .then(updatedTask => {
            loadTasks();
        });
}

function deleteTask(taskId) {
    fetch(`http://localhost:8080/task/${taskId}`, {
        method: 'DELETE'
    })
        .then(() => {
            loadTasks();
        });
}

form.addEventListener('submit', addTask);

loadTasks();

{/* <button class="btn-action" onclick="editTask(${task.id})">
<span class="material-symbols-outlined">
    edit
</span>
</button> */}