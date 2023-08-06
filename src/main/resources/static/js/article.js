document.addEventListener("DOMContentLoaded", function () {
    // Sélectionner tous les boutons d'entrée avec l'attribut data-num
    const buttons = document.querySelectorAll('input[type="button"]');

    // Ajouter un gestionnaire d'événement aux boutons
    buttons.forEach(function (button) {
        button.addEventListener("click", function () {
            // Récupérer la valeur de l'attribut data-num du bouton cliqué
            const dataNumValue = button.getAttribute("data-num");
            button.value = (button.value === "Modifier") ? "Enregistrer" : "Modifier";
            // Sélectionner tous les éléments <tr> qui ont le même numéro data-num que le bouton
            const trElements = document.querySelectorAll('tr[data-num="' + dataNumValue + '"]');
            var inputLibelle;
            var inputDescription;
            var inputPrix;
            // Retirer l'attribut readonly pour chaque élément <input> dans les éléments <tr>
            trElements.forEach(function (trElement) {
                const inputElements = trElement.querySelectorAll('input');
                const trId = parseInt(trElement.getAttribute("id"), 10);

                var saveData = false;
                // Créer un objet JSON avec l'ID de l'article

                inputElements.forEach(function (inputElement) {

                    if (inputElement.getAttribute("readonly")) {
                        inputElement.removeAttribute("readonly");
                        saveData = true;
                    } else {
                        switch (inputElement.getAttribute("id")) {
                            case 'libelle':
                                inputLibelle = inputElement.value;
                                console.log(inputLibelle)
                                break
                            case 'description':
                                inputDescription = inputElement.value;
                                break
                            case 'prix':
                                inputPrix = parseInt(inputElement.value, 10);
                                break
                        }

                        inputElement.setAttribute("readonly", "true");
                        saveData = false;
                    }
                });
                const requestBody = {
                    id: trId,
                    libelle: inputLibelle,
                    description: inputDescription,
                    prix: inputPrix
                };
                console.log(JSON.stringify(requestBody))
                // Configurer les options de la requête POST
                const requestOptions = {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(requestBody)

                };

                if (saveData) {
                    console.log(saveData)
                    // Envoyer la requête POST vers /api/article/modif
                    fetch('/api/article/modif', requestOptions)
                        .then(response => response.json())
                        .then(data => {
                            // Traiter la réponse de l'API si nécessaire
                            console.log(data);
                        })
                        .catch(error => {
                            // Gérer les erreurs s'il y en a
                            console.error('Erreur lors de la requête POST :', error);
                        });
                }

            });
        });
    });
});


