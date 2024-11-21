# @tablelogic的使用 —— 通义千问
    MyBatis-Plus中的@TableLogic注解主要用于实现数据库数据的逻辑删除功能。逻辑删除并不是真正从数据库中删除记录，而是通过在数据库表中设置一个标记字段（如is_deleted、status等）来表示这条记录是否被删除。‌
    
    使用方法
    ‌在实体类中添加逻辑删除字段‌：在实体类的属性上使用@TableLogic注解，表示该字段是逻辑删除字段。例如：
    
    java
    Copy Code
    @TableLogic
    private Integer del;
    ‌调用删除方法‌：当调用BaseMapper的deleteById(id)或者IService的removeById(id)时，MyBatis-Plus会将删除操作转变为更新操作，将逻辑删除字段的值设置为默认的已删除值（如1）。例如：
    
    java
    Copy Code
    deleteById(id); // 实际上执行的是 update 表名 set del=1 where id=xxx;
    ‌查询操作‌：在执行查询操作时，MyBatis-Plus会在查询语句的where条件中添加过滤条件，过滤掉已删除的数据。例如：
    
    sql
    Copy Code
    SELECT * FROM user WHERE del=0; // 默认情况下，未删除的值是0
    参数设置
    @TableLogic注解可以设置两个参数：
    
    value：未删除的值，默认值为0。
    delval：已删除的值，默认值为1。
    例如：
    java
    Copy Code
    @TableLogic(value="0", delval="1")
    private Integer del;
    如果不设置这两个参数，MyBatis-Plus会使用默认值。
    
    适用场景和限制
    @TableLogic注解只对自动注入的SQL起效，适用于需要保留数据历史记录但不希望真正删除数据的场景。例如，用户信息、订单信息等需要保留历史记录的数据表。
    
    通过使用@TableLogic注解，可以有效地实现数据库数据的逻辑删除功能，既保留了数据的历史记录，又避免了真正删除数据带来的问题。