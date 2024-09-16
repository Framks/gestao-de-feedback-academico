const PaginaInicio = () => {
    return(
        <section className="container">
            <div className="row">

            <article className="card text-white bg-dark my-3">
                <div className="card-header border-black">Atividades</div>
                <div className="card-body">
                    <h3 className="card-title">Novas atividades não avaliadas</h3>
                    <p>
                    Aqui ficara um breve dashboard das avaliações das aulas
                    </p>
                </div>
            </article>
            <article className="card text-white bg-dark my-3">
                <div className="card-header border-black">Aulas</div>
                <div className="card-body">
                    <h3 className="card-title">Novas Aulas não avaliadas</h3>
                    <p>
                        Aqui ficara um breve dashboard das avaliações das aulas
                    </p>
                </div>
            </article>
            </div>
        </section>
    )
}

export default PaginaInicio;