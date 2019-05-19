import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.sonatype.nexus.security.user.UserManager
import org.sonatype.nexus.security.role.NoSuchRoleException

List<Map<String, String>> actionDetails = []
Map scriptResults = [changed: false, error: false]
scriptResults.put('action_details', actionDetails)

parsed_args = new JsonSlurper().parseText(args)

authManager = security.getSecuritySystem().getAuthorizationManager(UserManager.DEFAULT_SOURCE)

def existingRole = null

try {
    existingRole = authManager.getRole(parsed_args.id)
} catch (NoSuchRoleException ignored) {
    // could not find role
}

privileges = (parsed_args.privileges == null ? new HashSet() : parsed_args.privileges.toSet())
roles = (parsed_args.roles == null ? new HashSet() : parsed_args.roles.toSet())

Map<String, String> currentResult = [id: parsed_args.id, name: parsed_args.name, status: 'no change']   

try {
    if (existingRole != null) {
        log.info('updating role')
        existingRole.setName(parsed_args.name)
        existingRole.setDescription(parsed_args.description)
        existingRole.setPrivileges(privileges)
        existingRole.setRoles(roles)
        authManager.updateRole(existingRole)
        currentResult.status = 'updated'
    } 
    else {
        log.info('creating role')
        log.info('id', parsed_args.id) 
        log.info('name', parsed_args.name) 
        log.info('desc', parsed_args.description) 
        log.info('privs', privileges.toList()) 
        log.info('roles', roles.toList())

        security.addRole(parsed_args.id, parsed_args.name, parsed_args.description, privileges.toList(), roles.toList())
        currentResult.status = 'created'
    }

    log.info("Role {} updated", parsed_args.name)
    scriptResults.changed = true
}
catch (Exception e){
    log.error("Role {} could not be updated", )
    currentResult.status = 'error'
    currentResult.put('error_msg', e.toString())
    scriptResults.error = true
}

scriptResults['action_details'].add(currentResult)
return JsonOutput.toJson(scriptResults)


MT21 MMEB 4471 6000 0000 7127 9509 050
MT21MMEB44716000000071279509050


  
  