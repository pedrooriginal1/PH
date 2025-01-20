let cart = [];  // Array para armazenar os itens no carrinho

// Função para adicionar um item ao carrinho
function addToCart(product, price) {
    cart.push({ product, price });
    updateCart();  // Atualiza o carrinho após adicionar um item
}

// Função para atualizar o conteúdo do carrinho
function updateCart() {
    const cartItemsContainer = document.getElementById('cart-items'); // Onde os itens são listados
    const cartButton = document.querySelector('.cart'); // Botão do carrinho
    cartItemsContainer.innerHTML = ''; // Limpa o conteúdo anterior do carrinho

    let total = 0;  // Variável para somar o total da compra
    cart.forEach(item => {
        const itemDiv = document.createElement('div');  // Cria o elemento do item
        itemDiv.classList.add('item');
        itemDiv.innerHTML = `${item.product} - R$ ${item.price.toFixed(2)}`;  // Exibe o nome e preço
        cartItemsContainer.appendChild(itemDiv);  // Adiciona o item à lista
        total += item.price;  // Adiciona o preço ao total
    });

    cartButton.innerHTML = `Carrinho (${cart.length})`;  // Atualiza o número de itens no botão do carrinho
}

// Função para alternar a visibilidade do carrinho
function toggleCart() {
    const cartContent = document.querySelector('.cart-content');
    cartContent.style.display = cartContent.style.display === 'block' ? 'none' : 'block';  // Alterna entre mostrar e esconder o carrinho
}

// Função para finalizar a compra
function checkout() {
    if (cart.length === 0) {
        alert('O carrinho está vazio!');  // Alerta se o carrinho estiver vazio
        return;
    }
    let total = cart.reduce((sum, item) => sum + item.price, 0);  // Calcula o total
    alert(`Total: R$ ${total.toFixed(2)}\nCompra realizada com sucesso!`);  // Exibe o total da compra
    cart = [];  // Limpa o carrinho após a compra
    updateCart();  // Atualiza a exibição do carrinho
    toggleCart();  // Fecha o carrinho
}
