<div class="header">
		<h2>Todos App</h2>
		<c:if test="${user.getId() > 0}">
			<a href="logout">Logout</a>
		</c:if>
</div>